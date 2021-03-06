package co.com.kallsonys.oms.crud.productos;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.datacontract.schemas._2004._07.productoentities.ProductoEntity;

import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;

import co.com.kallsonys.oms.backend.data.Product;
import co.com.kallsonys.oms.backend.entity.Categoria;
import co.com.kallsonys.oms.util.EUrlB2c;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class ProductGrid extends Grid<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2297234474340284760L;

	public ProductGrid() {
		setSizeFull();

		addColumn(produc ->
	      "<a href='" +EUrlB2c.URL_B2C.getValue()+produc.getId() + "' target='_blank'>Ver</a>",
	      new HtmlRenderer());
		addColumn(Product::getId).setCaption("Número");
		addColumn(Product::getCodigo).setCaption("Código");
		addColumn(Product::getProductName).setCaption("Nombre del producto");

		// Format and add " $" to price
		final DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setMinimumFractionDigits(2);
		addColumn(product -> decimalFormat.format(product.getPrice()) + " $")
		.setCaption("Precio").setComparator((p1, p2) -> {
			return p1.getPrice().compareTo(p2.getPrice());
		}).setStyleGenerator(product -> "align-right");

		addColumn(product -> decimalFormat.format(product.getValorDescuento()) + " $")
		.setCaption("Valor Descuento").setStyleGenerator(product -> "align-right");

		// Add an traffic light icon in front of availability
		//        addColumn(this::htmlFormatAvailability, new HtmlRenderer())
		//                .setCaption("Disponibilidad").setComparator((p1, p2) -> {
		//                    return p1.getAvailability().toString()
		//                            .compareTo(p2.getAvailability().toString());
		//                });

		// Show empty stock as "-"
		addColumn(product -> {
			if (product.getStockCount() == 0) {
				return "-";
			}
			return Integer.toString(product.getStockCount());
		}).setCaption("Cantidad Disponible").setComparator((p1, p2) -> {
			return Integer.compare(p1.getStockCount(), p2.getStockCount());
		}).setStyleGenerator(product -> "align-right");

		// Show all categories the product is in, separated by commas
		addColumn(this::formatCategories).setCaption("Categoria").setSortable(false);
		addColumn(Product::getUrlImagen).setCaption("URL Imagen").setSortable(false);
		addColumn(this::formatFabricante).setCaption("Fabricante").setSortable(false);
	}

	public Product getSelectedRow() {
		return asSingleSelect().getValue();
	}

	public void refresh(Product product) {
		getDataCommunicator().refresh(product);
	}

	//    private String htmlFormatAvailability(Product product) {
	//        Availability availability = product.getAvailability();
	//        String text = availability.toString();
	//
	//        String color = "";
	//        switch (availability) {
	//        case AVAILABLE:
	//            color = "#2dd085";
	//            break;
	//        case COMING:
	//            color = "#ffc66e";
	//            break;
	//        case DISCONTINUED:
	//            color = "#f54993";
	//            break;
	//        default:
	//            break;
	//        }
	//
	//        String iconCode = "<span class=\"v-icon\" style=\"font-family: "
	//                + VaadinIcons.CIRCLE.getFontFamily() + ";color:" + color
	//                + "\">&#x"
	//                + Integer.toHexString(VaadinIcons.CIRCLE.getCodepoint())
	//                + ";</span>";
	//
	//        return iconCode + " " + text;
	//    }

	private String formatCategories(Product product) {
		if (product.getCategoria() == null ) {
			return "";
		}
		return product.getCategoria().getNombre();
//		        return product.getCategoria().stream()
//		                .sorted(Comparator.comparing(Categoria::getIdCategoria))
//		                .map(Categoria::getNombre).collect(Collectors.joining(", "));
	}

	private String formatFabricante(Product product) {
		if (product.getFabricante() == null ) {
			return "";
		}
		return product.getFabricante().getFabricante();
	}
}
