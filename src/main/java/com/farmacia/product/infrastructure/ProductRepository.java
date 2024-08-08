package com.farmacia.product.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.product.domain.entity.Product;
import com.farmacia.product.domain.entity.ProductDto;
import com.farmacia.product.domain.service.ProductService;

public class ProductRepository implements ProductService {

    private Connection connection;

    public ProductRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProduct(Product product) {
        try {
            String query = """
                    INSERT INTO productos (codproducto, nombre, reginvima, fechaCaducidad, stock, stockmin, stockmax,
                    valorcompra, valorventa, idviaadmin, idlaboratorio, idpresentacion, idprincipioact,
                    idunidadmedida, idproveedor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getCodproducto());
            ps.setString(2, product.getNombre());
            ps.setString(3, product.getReginvima());
            ps.setString(4, product.getFechaCaducidad());
            ps.setInt(5, product.getStock());
            ps.setInt(6, product.getStockmin());
            ps.setInt(7, product.getStockmax());
            ps.setDouble(8, product.getValorcompra());
            ps.setDouble(9, product.getValorventa());
            ps.setInt(10, product.getIdviaadmin());
            ps.setInt(11, product.getIdlaboratorio());
            ps.setInt(12, product.getIdpresentacion());
            ps.setInt(13, product.getIdprincipioact());
            ps.setInt(14, product.getIdunidadmedida());
            ps.setString(15, product.getIdproveedor());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            String query = """
                    UPDATE productos SET
                        nombre = ?, reginvima = ?, fechaCaducidad = ?, stock = ?, stockmin = ?, stockmax = ?,
                        valorcompra = ?, valorventa = ?, idviaadmin = ?, idlaboratorio = ?, idpresentacion = ?,
                        idprincipioact = ?, idunidadmedida = ?, idproveedor = ?
                    WHERE codproducto = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, product.getNombre());
            ps.setString(2, product.getReginvima());
            ps.setString(3, product.getFechaCaducidad());
            ps.setInt(4, product.getStock());
            ps.setInt(5, product.getStockmin());
            ps.setInt(6, product.getStockmin());
            ps.setDouble(7, product.getValorcompra());
            ps.setDouble(8, product.getValorventa());
            ps.setInt(9, product.getIdviaadmin());
            ps.setInt(10, product.getIdlaboratorio());
            ps.setInt(11, product.getIdpresentacion());
            ps.setInt(12, product.getIdprincipioact());
            ps.setInt(13, product.getIdunidadmedida());
            ps.setString(14, product.getIdproveedor());
            ps.setString(15, product.getCodproducto());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(String id) {
        try {
            String query = "DELETE FROM productos WHERE codproducto = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findByIdProduct(String id) {
        Product product = new Product();
        try {
            String query = """
                    SELECT codproducto, nombre, reginvima, fechaCaducidad, stock, stockmin, stockmax,
                    valorcompra, valorventa, idviaadmin, idlaboratorio, idpresentacion, idprincipioact,
                    idunidadmedida, idproveedor FROM productos WHERE codproducto = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product.setCodproducto(rs.getString("codproducto"));
                product.setNombre(rs.getString("nombre"));
                product.setReginvima(rs.getString("reginvima"));
                product.setFechaCaducidad(rs.getString("fechaCaducidad"));
                product.setStock(rs.getInt("stock"));
                product.setStockmin(rs.getInt("stockmin"));
                product.setStockmax(rs.getInt("stockmax"));
                product.setValorcompra(rs.getDouble("valorcompra"));
                product.setValorventa(rs.getDouble("valorventa"));
                product.setIdviaadmin(rs.getInt("idviaadmin"));
                product.setIdlaboratorio(rs.getInt("idlaboratorio"));
                product.setIdpresentacion(rs.getInt("idpresentacion"));
                product.setIdprincipioact(rs.getInt("idprincipioact"));
                product.setIdunidadmedida(rs.getInt("idunidadmedida"));
                product.setIdproveedor(rs.getString("idproveedor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = """
                    SELECT codproducto, nombre, reginvima, fechaCaducidad, stock, stockmin, stockmax,
                    valorcompra, valorventa, idviaadmin, idlaboratorio, idpresentacion, idprincipioact,
                    idunidadmedida, idproveedor FROM productos
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setCodproducto(rs.getString("codproducto"));
                product.setNombre(rs.getString("nombre"));
                product.setReginvima(rs.getString("reginvima"));
                product.setFechaCaducidad(rs.getString("fechaCaducidad"));
                product.setStock(rs.getInt("stock"));
                product.setStockmin(rs.getInt("stockmin"));
                product.setStockmax(rs.getInt("stockmax"));
                product.setValorcompra(rs.getDouble("valorcompra"));
                product.setValorventa(rs.getDouble("valorventa"));
                product.setIdviaadmin(rs.getInt("idviaadmin"));
                product.setIdlaboratorio(rs.getInt("idlaboratorio"));
                product.setIdpresentacion(rs.getInt("idpresentacion"));
                product.setIdprincipioact(rs.getInt("idprincipioact"));
                product.setIdunidadmedida(rs.getInt("idunidadmedida"));
                product.setIdproveedor(rs.getString("idproveedor"));
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductDto findByIdProductDto(String id) {
        ProductDto productDto = new ProductDto();
        try {
            String query = """
                        SELECT
                    	pro.codproducto,
                        pro.nombre, pro.reginvima,
                        pro.fechaCaducidad, pro.stock,
                        pro.stockmin, pro.stockmax,
                        pro.valorcompra, pro.valorventa,
                        via.nombre AS nombreViaAdmin,
                        lab.nombre AS nombreLaboratorio,
                        pre.nombre AS nombrePresentacion,
                        pri.nombre AS nombrePrincipioAct,
                        uni.nombre AS nombreUnidadMedida,
                        prov.nombre AS nombreProveedor
                    FROM productos pro
                    INNER JOIN vias_administracion via ON pro.idviaadmin = via.idviaadmin
                    INNER JOIN laboratorios lab ON pro.idlaboratorio = lab.idlaboratorio
                    INNER JOIN presentaciones pre ON pro.idpresentacion = pre.idpresentacion
                    INNER JOIN principios_activos pri ON pro.idprincipioact = pri.idprincipioact
                    INNER JOIN unidades_medida uni ON pro.idunidadmedida = uni.idunidadmedida
                    INNER JOIN proveedores prov ON pro.idproveedor = prov.idproveedor
                    WHERE codproducto = ?
                                        """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productDto.setCodproducto(rs.getString("codproducto"));
                productDto.setNombre(rs.getString("nombre"));
                productDto.setReginvima(rs.getString("reginvima"));
                productDto.setFechaCaducidad(rs.getString("fechaCaducidad"));
                productDto.setStock(rs.getInt("stock"));
                productDto.setStockmin(rs.getInt("stockmin"));
                productDto.setStockmax(rs.getInt("stockmax"));
                productDto.setValorcompra(rs.getDouble("valorcompra"));
                productDto.setValorventa(rs.getDouble("valorventa"));

                productDto.setNombreViaAdmin(rs.getString("nombreViaAdmin"));
                productDto.setNombreLaboratorio(rs.getString("nombreLaboratorio"));
                productDto.setNombrePresentacion(rs.getString("nombrePresentacion"));
                productDto.setNombrePrincipioAct(rs.getString("nombrePrincipioAct"));
                productDto.setNombreUnidadMedida(rs.getString("nombreUnidadMedida"));
                productDto.setNombreProveedor(rs.getString("nombreProveedor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDto;
    }

    @Override
    public List<ProductDto> findAllProductsDto() {
        List<ProductDto> productsDto = new ArrayList<>();
        try {
            String query = """
                                SELECT
                            	pro.codproducto,
                                pro.nombre, pro.reginvima,
                                pro.fechaCaducidad, pro.stock,
                                pro.stockmin, pro.stockmax,
                                pro.valorcompra, pro.valorventa,
                                via.nombre AS nombreViaAdmin,
                                lab.nombre AS nombreLaboratorio,
                                pre.nombre AS nombrePresentacion,
                                pri.nombre AS nombrePrincipioAct,
                                uni.nombre AS nombreUnidadMedida,
                                prov.nombre AS nombreProveedor
                            FROM productos pro
                            INNER JOIN vias_administracion via ON pro.idviaadmin = via.idviaadmin
                            INNER JOIN laboratorios lab ON pro.idlaboratorio = lab.idlaboratorio
                            INNER JOIN presentaciones pre ON pro.idpresentacion = pre.idpresentacion
                            INNER JOIN principios_activos pri ON pro.idprincipioact = pri.idprincipioact
                            INNER JOIN unidades_medida uni ON pro.idunidadmedida = uni.idunidadmedida
                            INNER JOIN proveedores prov ON pro.idproveedor = prov.idproveedor
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ProductDto productDto = new ProductDto();
                productDto.setCodproducto(rs.getString("codproducto"));
                productDto.setNombre(rs.getString("nombre"));
                productDto.setReginvima(rs.getString("reginvima"));
                productDto.setFechaCaducidad(rs.getString("fechaCaducidad"));
                productDto.setStock(rs.getInt("stock"));
                productDto.setStockmin(rs.getInt("stockmin"));
                productDto.setStockmax(rs.getInt("stockmax"));
                productDto.setValorcompra(rs.getDouble("valorcompra"));
                productDto.setValorventa(rs.getDouble("valorventa"));

                productDto.setNombreViaAdmin(rs.getString("nombreViaAdmin"));
                productDto.setNombreLaboratorio(rs.getString("nombreLaboratorio"));
                productDto.setNombrePresentacion(rs.getString("nombrePresentacion"));
                productDto.setNombrePrincipioAct(rs.getString("nombrePrincipioAct"));
                productDto.setNombreUnidadMedida(rs.getString("nombreUnidadMedida"));
                productDto.setNombreProveedor(rs.getString("nombreProveedor"));
                productsDto.add(productDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsDto;
    }

}
