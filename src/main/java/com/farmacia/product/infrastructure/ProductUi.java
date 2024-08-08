package com.farmacia.product.infrastructure;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.product.application.CreateProductUseCase;
import com.farmacia.product.application.DeleteProductUseCase;
import com.farmacia.product.application.FindAllProductUseCase;
import com.farmacia.product.application.FindAllProductUseDtoCase;
import com.farmacia.product.application.FindByIdProductDtoUseCase;
import com.farmacia.product.application.FindByIdProductUseCase;
import com.farmacia.product.application.UpdateProductUseCase;
import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.entity.ProductDto;

public class ProductUi {
        private CreateProductUseCase createProductUseCase;
        private UpdateProductUseCase updateProductUseCase;
        private DeleteProductUseCase deleteProductUseCase;
        private FindByIdProductUseCase findByIdProductUseCase;
        private FindByIdProductDtoUseCase findByIdProductDtoUseCase;
        private FindAllProductUseCase findAllProductUseCase;
        private FindAllProductUseDtoCase findAllProductUseDtoCase;

        public ProductUi(CreateProductUseCase createProductUseCase, UpdateProductUseCase updateProductUseCase,
                        DeleteProductUseCase deleteProductUseCase, FindByIdProductUseCase findByIdProductUseCase,
                        FindByIdProductDtoUseCase findByIdProductDtoUseCase,
                        FindAllProductUseCase findAllProductUseCase,
                        FindAllProductUseDtoCase findAllProductUseDtoCase) {
                this.createProductUseCase = createProductUseCase;
                this.updateProductUseCase = updateProductUseCase;
                this.deleteProductUseCase = deleteProductUseCase;
                this.findByIdProductUseCase = findByIdProductUseCase;
                this.findByIdProductDtoUseCase = findByIdProductDtoUseCase;
                this.findAllProductUseCase = findAllProductUseCase;
                this.findAllProductUseDtoCase = findAllProductUseDtoCase;
        }

        public void showAllProducts(List<Product> products) {

                String[] columns = { "Código", "Nombre", "INVIMA", "Fecha Caducidad", "Stock", "Stock Min", "Stock Max",
                                "Valor Compra", "Valor Venta" };

                DefaultTableModel model = new DefaultTableModel(columns, 0);

                products.forEach(product -> {
                        Object[] row = {
                                        product.getCodproducto(),
                                        product.getNombre(),
                                        product.getReginvima(),
                                        product.getFechaCaducidad(),
                                        product.getStock(),
                                        product.getStockmin(),
                                        product.getStockmax(),
                                        product.getValorcompra(),
                                        product.getValorventa()
                        };
                        model.addRow(row);
                });

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                JPanel panel = new JPanel();

                table.setPreferredSize(new Dimension(800, 400));
                scrollPane.setPreferredSize(new Dimension(800, 400));
                panel.setPreferredSize(new Dimension(800, 400));

                panel.add(scrollPane);
                JOptionPane.showMessageDialog(null, panel, "Product List", JOptionPane.PLAIN_MESSAGE);

        }

        public void showProduct(Product product) {

                String[] columns = { "Código", "Nombre", "INVIMA", "Fecha Caducidad", "Stock", "Stock Min", "Stock Max",
                                "Valor Compra", "Valor Venta" };
                DefaultTableModel model = new DefaultTableModel(columns, 0);

                Object[] row = {
                                product.getCodproducto(),
                                product.getNombre(),
                                product.getReginvima(),
                                product.getFechaCaducidad(),
                                product.getStock(),
                                product.getStockmin(),
                                product.getStockmax(),
                                product.getValorcompra(),
                                product.getValorventa()
                };
                model.addRow(row);

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                JPanel panel = new JPanel();

                table.setPreferredSize(new Dimension(800, 400));
                scrollPane.setPreferredSize(new Dimension(800, 400));
                panel.setPreferredSize(new Dimension(800, 400));

                panel.add(scrollPane);
                JOptionPane.showMessageDialog(null, panel, "Product", JOptionPane.PLAIN_MESSAGE);

        }

        public void showAllProductsDto(List<ProductDto> productsDto) {
                String[] columns = { "Código", "Nombre", "INVIMA", "Fecha Caducidad", "Stock", "Stock Min", "Stock Max",
                                "Valor Compra", "Valor Venta", "Via Admin", "Laboratorio", "Presentacion",
                                "Principio Act",
                                "Unidad Medida", "Proveedor" };
                DefaultTableModel model = new DefaultTableModel(columns, 0);

                productsDto.forEach(productDto -> {
                        Object[] row = {
                                        productDto.getCodproducto(),
                                        productDto.getNombre(),
                                        productDto.getReginvima(),
                                        productDto.getFechaCaducidad(),
                                        productDto.getStock(),
                                        productDto.getStockmin(),
                                        productDto.getStockmax(),
                                        productDto.getValorcompra(),
                                        productDto.getValorventa(),
                                        productDto.getNombreViaAdmin(),
                                        productDto.getNombreLaboratorio(),
                                        productDto.getNombrePresentacion(),
                                        productDto.getNombrePrincipioAct(),
                                        productDto.getNombreUnidadMedida(),
                                        productDto.getNombreProveedor()
                        };
                        model.addRow(row);
                });

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                JPanel panel = new JPanel();

                table.setPreferredSize(new Dimension(1250, 400));
                scrollPane.setPreferredSize(new Dimension(1250, 400));
                panel.setPreferredSize(new Dimension(1250, 400));

                panel.add(scrollPane);
                JOptionPane.showMessageDialog(null, panel, "Products Dto List", JOptionPane.PLAIN_MESSAGE);
        }

        public void showProductDto(ProductDto productDto) {

                String[] columns = { "Código", "Nombre", "INVIMA", "Fecha Caducidad", "Stock", "Stock Min", "Stock Max",
                                "Valor Compra", "Valor Venta", "Via Admin", "Laboratorio", "Presentacion",
                                "Principio Act",
                                "Unidad Medida", "Proveedor" };

                DefaultTableModel model = new DefaultTableModel(columns, 0);

                Object[] row = {
                                productDto.getCodproducto(),
                                productDto.getNombre(),
                                productDto.getReginvima(),
                                productDto.getFechaCaducidad(),
                                productDto.getStock(),
                                productDto.getStockmin(),
                                productDto.getStockmax(),
                                productDto.getValorcompra(),
                                productDto.getValorventa(),
                                productDto.getNombreViaAdmin(),
                                productDto.getNombreLaboratorio(),
                                productDto.getNombrePresentacion(),
                                productDto.getNombrePrincipioAct(),
                                productDto.getNombreUnidadMedida(),
                                productDto.getNombreProveedor()
                };
                model.addRow(row);

                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                JPanel panel = new JPanel();

                table.setPreferredSize(new Dimension(1250, 400));
                scrollPane.setPreferredSize(new Dimension(1250, 400));
                panel.setPreferredSize(new Dimension(1250, 400));

                panel.add(scrollPane);
                JOptionPane.showMessageDialog(null, panel, "Product Dto", JOptionPane.PLAIN_MESSAGE);

        }

        public void addProduct() {
                Product product = new Product();
                product.setCodproducto(JOptionPane.showInputDialog(null, "Ingrese el código del producto"));
                product.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del producto"));
                product.setReginvima(JOptionPane.showInputDialog(null, "Ingrese el Registro INVIMA del producto"));
                product.setFechaCaducidad(
                                JOptionPane.showInputDialog(null,
                                                "Ingrese fecha de caducidad del producto (YYYY-MM-DD)"));
                product.setStock(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el stock del producto")));
                product.setStockmin(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el stock minimo del producto")));
                product.setStockmax(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el stock maximo del producto")));
                product.setValorcompra(
                                Double.parseDouble(JOptionPane.showInputDialog(null,
                                                "Ingrese el valor de compra del producto")));
                product.setValorventa(product.getValorcompra() * (1 + product.getGanancia()));
                product.setIdviaadmin(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el ID de la via de administracion")));
                product.setIdlaboratorio(
                                Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del laboratorio")));
                product.setIdpresentacion(
                                Integer.parseInt(
                                                JOptionPane.showInputDialog(null, "Ingrese el ID de la presentacion")));
                product.setIdprincipioact(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el ID del principio activo")));
                product.setIdunidadmedida(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el ID de la unidad de medida")));
                product.setIdproveedor(JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor"));
                createProductUseCase.execute(product);
        }

        public void updateProduct() {
                Product product = findByIdProduct();

                product.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del producto"));
                product.setReginvima(JOptionPane.showInputDialog(null, "Ingrese el Registro INVIMA del producto"));
                product.setFechaCaducidad(
                                JOptionPane.showInputDialog(null,
                                                "Ingrese fecha de caducidad del producto (YYYY-MM-DD)"));
                product.setStock(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el stock del producto")));
                product.setStockmin(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el stock minimo del producto")));
                product.setStockmax(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el stock maximo del producto")));
                product.setValorcompra(
                                Double.parseDouble(JOptionPane.showInputDialog(null,
                                                "Ingrese el valor de compra del producto")));
                product.setValorventa(product.getValorcompra() * (1 + product.getGanancia()));
                product.setIdviaadmin(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el ID de la via de administracion")));
                product.setIdlaboratorio(
                                Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del laboratorio")));
                product.setIdpresentacion(
                                Integer.parseInt(
                                                JOptionPane.showInputDialog(null, "Ingrese el ID de la presentacion")));
                product.setIdprincipioact(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el ID del principio activo")));
                product.setIdunidadmedida(
                                Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Ingrese el ID de la unidad de medida")));
                product.setIdproveedor(JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor"));

                updateProductUseCase.execute(product);
        }

        public void findAllProducts() {
                List<Product> products = findAllProductUseCase.execute();
                showAllProducts(products);
        }

        public Product findByIdProduct() {
                String id = JOptionPane.showInputDialog(null, "Ingrese el ID del producto");
                Product product = findByIdProductUseCase.execute(id);
                showProduct(product);
                return product;
        }

        public void deleteProduct() {
                Product product = findByIdProduct();
                deleteProductUseCase.execute(product.getCodproducto());
        }

        public void findAllProductsDto() {
                List<ProductDto> productsDto = findAllProductUseDtoCase.execute();
                showAllProductsDto(productsDto);
        }

        public void findProductDtoById() {
                String id = JOptionPane.showInputDialog(null, "Ingrese el ID del producto");
                ProductDto productDto = findByIdProductDtoUseCase.execute(id);
                showProductDto(productDto);
        }

}
