package co.com.kallsonys.oms.crud.productos;

import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

import co.com.kallsonys.oms.backend.DataService;
import co.com.kallsonys.oms.backend.data.Product;

import com.vaadin.data.provider.AbstractDataProvider;
import com.vaadin.data.provider.Query;

public class ProductDataProvider
        extends AbstractDataProvider<Product, String> {
    
    /** Text filter that can be changed separately. */
    private String filterText = "";

    /**
     * Store given product to the backing data service.
     * 
     * @param product
     *            the updated or new product
     */
    public void save(Product product) {
        boolean newProduct = product.getId() == -1;
        
        DataService.get().updateProduct(product);
        if (newProduct) {
            refreshAll();
        } else {
            refreshItem(product);
        }
    }

    /**
     * Delete given product from the backing data service.
     * 
     * @param product
     *            the product to be deleted
     */
    public void delete(Product product) {
        DataService.get().deleteProduct(product.getId());
        refreshAll();
    }
    
    /**
     * Sets the filter to use for the this data provider and refreshes data.
     * <p>
     * Filter is compared for product name, availability and category.
     * 
     * @param filterText
     *           the text to filter by, never null
     */
    public void setFilter(String filterText) {
        Objects.requireNonNull(filterText, "El filtro no puede ser nulo");
        if (Objects.equals(this.filterText, filterText.trim())) {
            return;
        }
        this.filterText = filterText.trim();
        
        refreshAll();
    }
    
    @Override
    public Integer getId(Product product) {
        Objects.requireNonNull(product, "Nos e puede proveer un id para un producto nulo.");
        
        return product.getId();
    }
    
    @Override
    public boolean isInMemory() {
        return true;
    }

    @Override
    public int size(Query<Product, String> t) {
        return (int) fetch(t).count();
    }

    @Override
    public Stream<Product> fetch(Query<Product, String> query) {
        if (filterText.isEmpty()) {
            return DataService.get().getAllProducts().stream();
        }
        return DataService.get().getAllProducts().stream().filter(
                product -> passesFilter(product.getProductName(), filterText)
                        || passesFilter(product.getCodigo(), filterText)
                        || passesFilter(product.getDescripcion(), filterText));
    }

    private boolean passesFilter(Object object, String filterText) {
        return object != null && object.toString().toLowerCase(Locale.ENGLISH)
                .contains(filterText);
    }
}
