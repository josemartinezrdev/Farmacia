package com.farmacia;

import com.farmacia.via_administracion.application.CreateViaAdminisUseCase;
import com.farmacia.via_administracion.application.DeleteViaAdminisUseCase;
import com.farmacia.via_administracion.application.FindByIdViaAdminisUseCase;
import com.farmacia.via_administracion.application.FindViaAdminisUseCase;
import com.farmacia.via_administracion.application.UpdateViaAminisUseCase;
import com.farmacia.via_administracion.domain.service.ViaAdminisService;
import com.farmacia.via_administracion.infrastructure.ViaAdminisRepository;
import com.farmacia.via_administracion.infrastructure.ViaAdminisUi;
import com.farmacia.barrio.application.CreateBarrioUseCase;
import com.farmacia.barrio.application.DeleteBarrioUseCase;
import com.farmacia.barrio.application.FindBarrioDtoUseCase;
import com.farmacia.barrio.application.FindBarrioUseCase;
import com.farmacia.barrio.application.FindByIdBarrioDtoUseCase;
import com.farmacia.barrio.application.FindByIdBarrioUseCase;
import com.farmacia.barrio.application.UpdateBarrioUseCase;
import com.farmacia.barrio.domain.service.BarrioService;
import com.farmacia.barrio.infrastructure.BarrioRepository;
import com.farmacia.barrio.infrastructure.BarrioUi;
import com.farmacia.city.application.CreateCityUseCase;
import com.farmacia.city.application.DeleteCityUseCase;
import com.farmacia.city.application.FindByIdCityUseCase;
import com.farmacia.city.application.FindCityUseCase;
import com.farmacia.city.application.UpdateCityUseCase;
import com.farmacia.city.domain.service.CityService;
import com.farmacia.city.infrastructure.CityRepository;
import com.farmacia.city.infrastructure.CityUi;
import com.farmacia.customer.application.CreateCustomerUseCase;
import com.farmacia.customer.application.DeleteCustomerUseCase;
import com.farmacia.customer.application.FindByIdCustomerDtoUseCase;
import com.farmacia.customer.application.FindByIdCustomerUseCase;
import com.farmacia.customer.application.FindCustomerDtoUseCase;
import com.farmacia.customer.application.FindCustomerUseCase;
import com.farmacia.customer.application.UpdateCustomerUseCase;
import com.farmacia.customer.domain.service.CustomerService;
import com.farmacia.customer.infrastructure.CustomerRepository;
import com.farmacia.customer.infrastructure.CustomerUi;
import com.farmacia.laboratory.application.CreateLaboratoryUseCase;
import com.farmacia.laboratory.application.DeleteLaboratoryUseCase;
import com.farmacia.laboratory.application.FindAllLaboratoryUseCase;
import com.farmacia.laboratory.application.FindByIdLaboratoryUseCase;
import com.farmacia.laboratory.application.UpdateLaboratoryUseCase;
import com.farmacia.laboratory.domain.service.LaboratoryService;
import com.farmacia.laboratory.infrastructure.LaboratoryRepository;
import com.farmacia.laboratory.infrastructure.LaboratoryUi;
import com.farmacia.presentation.application.CreatePresentationUseCase;
import com.farmacia.presentation.application.DeletePresentationUseCase;
import com.farmacia.presentation.application.FindAllPresentationsUseCase;
import com.farmacia.presentation.application.FindByIdPresentationUseCase;
import com.farmacia.presentation.application.UpdatePresentationUseCase;
import com.farmacia.presentation.domain.service.PresentationService;
import com.farmacia.presentation.infrastructure.PresentationRepository;
import com.farmacia.presentation.infrastructure.PresentationUi;
import com.farmacia.principio_activo.application.CreatePrincipioActivoUseCase;
import com.farmacia.principio_activo.application.DeletePrincipioActivoUseCase;
import com.farmacia.principio_activo.application.FindAllPrincipioActivoUseCase;
import com.farmacia.principio_activo.application.FindByIdPrincipioActivoUseCase;
import com.farmacia.principio_activo.application.UpdatePrincipioActivoUseCase;
import com.farmacia.principio_activo.domain.service.PrincipioActivoService;
import com.farmacia.principio_activo.infrastructure.PrincipioActivoRepository;
import com.farmacia.principio_activo.infrastructure.PrincipioActivoUi;
import com.farmacia.product.application.CreateProductUseCase;
import com.farmacia.product.application.DeleteProductUseCase;
import com.farmacia.product.application.FindAllProductUseCase;
import com.farmacia.product.application.FindAllProductUseDtoCase;
import com.farmacia.product.application.FindByIdProductDtoUseCase;
import com.farmacia.product.application.FindByIdProductUseCase;
import com.farmacia.product.application.UpdateProductUseCase;
import com.farmacia.product.domain.service.ProductService;
import com.farmacia.product.infrastructure.ProductRepository;
import com.farmacia.product.infrastructure.ProductUi;
import com.farmacia.proveedor.application.CreateProveedorUseCase;
import com.farmacia.proveedor.application.DeleteProveedorUseCase;
import com.farmacia.proveedor.application.FindAllProveedorDtoUseCase;
import com.farmacia.proveedor.application.FindAllProveedorUseCase;
import com.farmacia.proveedor.application.FindByIdProveedorDtoUseCase;
import com.farmacia.proveedor.application.FindByIdProveedorUseCase;
import com.farmacia.proveedor.application.UpdateProveedorUseCase;
import com.farmacia.proveedor.domain.service.ProveedorService;
import com.farmacia.proveedor.infrastructure.ProveedorRepository;
import com.farmacia.proveedor.infrastructure.ProveedorUi;
import com.farmacia.type_document.application.CreateTypeDocumentUseCase;
import com.farmacia.type_document.application.DeleteTypeDocumentUseCase;
import com.farmacia.type_document.application.FindByIdTypeDocumentUseCase;
import com.farmacia.type_document.application.FindTypeDocumentUseCase;
import com.farmacia.type_document.application.UpdateTypeDocumentUseCase;
import com.farmacia.type_document.domain.service.TypeDocumentService;
import com.farmacia.type_document.infrastructure.TypeDocumentRepository;
import com.farmacia.type_document.infrastructure.TypeDocumentUi;
import com.farmacia.unidad_medida.application.CreateUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.DeleteUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.FindAllUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.FindByIdUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.UpdateUnidadMedidaUseCase;
import com.farmacia.unidad_medida.domain.service.UnidadMedidaService;
import com.farmacia.unidad_medida.infrastructure.UnidadMedidaRepository;
import com.farmacia.unidad_medida.infrastructure.UnidadMedidaUi;

public class Main {
        public static void main(String[] args) {

                // ! RECUERDA SIEMPRE ACTUALIZAR EL CONSTRUCTOR DEL UI ATENCIONNN

                // Domino: entidad
                // Domino: servicio
                // Aplicacion: Caso de uso
                // Infraestructura: UI
                // Infraestructura: Repositorio

                CityService cityService = new CityRepository();
                CreateCityUseCase createCityUseCase = new CreateCityUseCase(cityService);
                UpdateCityUseCase updateCityUseCase = new UpdateCityUseCase(cityService);
                FindCityUseCase findCityUseCase = new FindCityUseCase(cityService);
                FindByIdCityUseCase findByIdCityUseCase = new FindByIdCityUseCase(cityService);
                DeleteCityUseCase deleteCityUseCase = new DeleteCityUseCase(cityService);

                CityUi cityUi = new CityUi(createCityUseCase, updateCityUseCase,
                                findCityUseCase, findByIdCityUseCase,
                                deleteCityUseCase);

                // cityUi.addCity();
                // cityUi.updateCity();
                // cityUi.findAllCities();
                // cityUi.findCityById();
                // cityUi.deleteCity();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                TypeDocumentService typeDocumentService = new TypeDocumentRepository();

                CreateTypeDocumentUseCase createTypeDocument = new CreateTypeDocumentUseCase(typeDocumentService);
                UpdateTypeDocumentUseCase updateTypeDocumentUseCase = new UpdateTypeDocumentUseCase(
                                typeDocumentService);
                FindTypeDocumentUseCase findTypeDocumentUseCase = new FindTypeDocumentUseCase(typeDocumentService);
                FindByIdTypeDocumentUseCase findByIdTypeDocumentUseCase = new FindByIdTypeDocumentUseCase(
                                typeDocumentService);
                DeleteTypeDocumentUseCase deleteTypeDocumentUseCase = new DeleteTypeDocumentUseCase(
                                typeDocumentService);

                TypeDocumentUi typeDocumentUi = new TypeDocumentUi(createTypeDocument, updateTypeDocumentUseCase,
                                findTypeDocumentUseCase, findByIdTypeDocumentUseCase, deleteTypeDocumentUseCase);

                // typeDocumentUi.addTypeDocument();
                // typeDocumentUi.updateTypeDocument();
                // typeDocumentUi.findAllTypesDocuments();
                // typeDocumentUi.findTypeDocumentById();
                // typeDocumentUi.deleteTypeDocument();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                BarrioService barrioService = new BarrioRepository();
                CreateBarrioUseCase createBarrioUseCase = new CreateBarrioUseCase(barrioService);
                UpdateBarrioUseCase updateBarrioUseCase = new UpdateBarrioUseCase(barrioService);
                FindBarrioUseCase findBarrioUseCase = new FindBarrioUseCase(barrioService);
                FindByIdBarrioUseCase findByIdBarrioUseCase = new FindByIdBarrioUseCase(barrioService);
                DeleteBarrioUseCase deleteBarrioUseCase = new DeleteBarrioUseCase(barrioService);
                FindBarrioDtoUseCase findBarrioDtoUseCase = new FindBarrioDtoUseCase(barrioService);
                FindByIdBarrioDtoUseCase findByIdBarrioDtoUseCase = new FindByIdBarrioDtoUseCase(barrioService);

                BarrioUi barrioUi = new BarrioUi(createBarrioUseCase, updateBarrioUseCase, findBarrioUseCase,
                                findByIdBarrioUseCase, deleteBarrioUseCase, findBarrioDtoUseCase,
                                findByIdBarrioDtoUseCase);

                // barrioUi.addBarrio();
                // barrioUi.updateBarrio();
                // barrioUi.findAllBarrios();
                // barrioUi.findBarrioById();
                // barrioUi.deleteBarrio();

                // barrioUi.findBarrioDtoById();
                // barrioUi.findAllBarriosDto();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                CustomerService customerService = new CustomerRepository();
                CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerService);
                UpdateCustomerUseCase updateCustomerUseCase = new UpdateCustomerUseCase(customerService);
                FindCustomerUseCase findCustomerUseCase = new FindCustomerUseCase(customerService);
                FindByIdCustomerUseCase findByIdCustomerUseCase = new FindByIdCustomerUseCase(customerService);
                DeleteCustomerUseCase deleteCustomerUseCase = new DeleteCustomerUseCase(customerService);
                FindByIdCustomerDtoUseCase findByIdCustomerDtoUseCase = new FindByIdCustomerDtoUseCase(customerService);
                FindCustomerDtoUseCase findCustomerDtoUseCase = new FindCustomerDtoUseCase(customerService);

                CustomerUi customerUi = new CustomerUi(createCustomerUseCase, updateCustomerUseCase,
                                findCustomerUseCase, findByIdCustomerUseCase, deleteCustomerUseCase,
                                findByIdCustomerDtoUseCase, findCustomerDtoUseCase);

                // customerUi.addCustomer();
                // customerUi.updateCustomer();
                // customerUi.findAllCustomers();
                // customerUi.findCustomerById();
                // customerUi.deleteCustomer();

                // customerUi.findAllCustomersDto();
                // customerUi.findCustomerDtoById();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                ViaAdminisService viaAdminisService = new ViaAdminisRepository();
                CreateViaAdminisUseCase createViaAdminisUseCase = new CreateViaAdminisUseCase(viaAdminisService);
                UpdateViaAminisUseCase updateViaAminisUseCase = new UpdateViaAminisUseCase(viaAdminisService);
                DeleteViaAdminisUseCase deleteViaAdminisUseCase = new DeleteViaAdminisUseCase(viaAdminisService);
                FindByIdViaAdminisUseCase findByIdViaAdminisUseCase = new FindByIdViaAdminisUseCase(viaAdminisService);
                FindViaAdminisUseCase findViaAdminisUseCase = new FindViaAdminisUseCase(viaAdminisService);
                ViaAdminisUi viaAdminisUi = new ViaAdminisUi(createViaAdminisUseCase, updateViaAminisUseCase,
                                deleteViaAdminisUseCase, findByIdViaAdminisUseCase, findViaAdminisUseCase);

                // viaAdminisUi.addViaAdminis();
                // viaAdminisUi.updateViaAdminis();
                // viaAdminisUi.findAllViasAdminis();
                // viaAdminisUi.findViaAdminisById();
                // viaAdminisUi.deleteViaAdminis();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                LaboratoryService laboratoryService = new LaboratoryRepository();
                CreateLaboratoryUseCase createLaboratoryUseCase = new CreateLaboratoryUseCase(laboratoryService);
                UpdateLaboratoryUseCase updateLaboratoryUseCase = new UpdateLaboratoryUseCase(laboratoryService);
                DeleteLaboratoryUseCase deleteLaboratoryUseCase = new DeleteLaboratoryUseCase(laboratoryService);
                FindAllLaboratoryUseCase findAllLaboratoryUseCase = new FindAllLaboratoryUseCase(laboratoryService);
                FindByIdLaboratoryUseCase findByIdLaboratoryUseCase = new FindByIdLaboratoryUseCase(laboratoryService);

                LaboratoryUi laboratoryUi = new LaboratoryUi(createLaboratoryUseCase, updateLaboratoryUseCase,
                                deleteLaboratoryUseCase, findAllLaboratoryUseCase, findByIdLaboratoryUseCase);

                // laboratoryUi.addLaboratory();
                // laboratoryUi.updateLaboratory();
                // laboratoryUi.deleteLaboratory();
                // laboratoryUi.findAllLaboratories();
                // laboratoryUi.findByIdLaboratory();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                PresentationService presentationService = new PresentationRepository();
                CreatePresentationUseCase createPresentationUseCase = new CreatePresentationUseCase(
                                presentationService);
                UpdatePresentationUseCase updatePresentationUseCase = new UpdatePresentationUseCase(
                                presentationService);
                DeletePresentationUseCase deletePresentationUseCase = new DeletePresentationUseCase(
                                presentationService);
                FindByIdPresentationUseCase findByIdPresentationUseCase = new FindByIdPresentationUseCase(
                                presentationService);
                FindAllPresentationsUseCase findAllPresentationsUseCase = new FindAllPresentationsUseCase(
                                presentationService);

                PresentationUi presentationUi = new PresentationUi(createPresentationUseCase, updatePresentationUseCase,
                                deletePresentationUseCase, findByIdPresentationUseCase, findAllPresentationsUseCase);

                // presentationUi.addPresentation();
                // presentationUi.updatePresentation();
                // presentationUi.deletePresentation();
                // presentationUi.findByIdPresentation();
                // presentationUi.findAllPresentations();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                PrincipioActivoService principioActivoService = new PrincipioActivoRepository();
                CreatePrincipioActivoUseCase createPrincipioActivoUseCase = new CreatePrincipioActivoUseCase(
                                principioActivoService);
                UpdatePrincipioActivoUseCase updatePrincipioActivoUseCase = new UpdatePrincipioActivoUseCase(
                                principioActivoService);
                DeletePrincipioActivoUseCase deletePrincipioActivoUseCase = new DeletePrincipioActivoUseCase(
                                principioActivoService);
                FindByIdPrincipioActivoUseCase findByIdPrincipioActivoUseCase = new FindByIdPrincipioActivoUseCase(
                                principioActivoService);
                FindAllPrincipioActivoUseCase findAllPrincipioActivoUseCase = new FindAllPrincipioActivoUseCase(
                                principioActivoService);

                PrincipioActivoUi principioActivoUi = new PrincipioActivoUi(createPrincipioActivoUseCase,
                                updatePrincipioActivoUseCase, deletePrincipioActivoUseCase,
                                findByIdPrincipioActivoUseCase,
                                findAllPrincipioActivoUseCase);

                // principioActivoUi.addPrincipioAct();
                // principioActivoUi.updatePrincipioAct();
                // principioActivoUi.deletePrincipioAct();
                // principioActivoUi.findAllPrincipiosAct();
                // principioActivoUi.findByIdPrincipioAct();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                UnidadMedidaService unidadMedidaService = new UnidadMedidaRepository();

                CreateUnidadMedidaUseCase createUnidadMedidaUseCase = new CreateUnidadMedidaUseCase(
                                unidadMedidaService);
                UpdateUnidadMedidaUseCase updateUnidadMedidaUseCase = new UpdateUnidadMedidaUseCase(
                                unidadMedidaService);
                DeleteUnidadMedidaUseCase deleteUnidadMedidaUseCase = new DeleteUnidadMedidaUseCase(
                                unidadMedidaService);
                FindByIdUnidadMedidaUseCase findByIdUnidadMedidaUseCase = new FindByIdUnidadMedidaUseCase(
                                unidadMedidaService);
                FindAllUnidadMedidaUseCase findAllUnidadMedidaUseCase = new FindAllUnidadMedidaUseCase(
                                unidadMedidaService);

                UnidadMedidaUi unidadMedidaUi = new UnidadMedidaUi(createUnidadMedidaUseCase,
                                updateUnidadMedidaUseCase, deleteUnidadMedidaUseCase, findByIdUnidadMedidaUseCase,
                                findAllUnidadMedidaUseCase);

                // unidadMedidaUi.addUnidadMedida();
                // unidadMedidaUi.updateUnidadMedida();
                // unidadMedidaUi.deleteUnidadMedida();
                // unidadMedidaUi.findAllUnidadesMedidas();
                // unidadMedidaUi.findByIdUnidadMedida();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                ProveedorService proveedorService = new ProveedorRepository();

                CreateProveedorUseCase createProveedorUseCase = new CreateProveedorUseCase(proveedorService);
                UpdateProveedorUseCase updateProveedorUseCase = new UpdateProveedorUseCase(proveedorService);
                DeleteProveedorUseCase deleteProveedorUseCase = new DeleteProveedorUseCase(proveedorService);
                FindByIdProveedorUseCase findByIdProveedorUseCase = new FindByIdProveedorUseCase(proveedorService);
                FindByIdProveedorDtoUseCase findByIdProveedorDtoUseCase = new FindByIdProveedorDtoUseCase(
                                proveedorService);
                FindAllProveedorUseCase findAllProveedorUseCase = new FindAllProveedorUseCase(proveedorService);
                FindAllProveedorDtoUseCase findAllProveedorDtoUseCase = new FindAllProveedorDtoUseCase(
                                proveedorService);

                ProveedorUi proveedorUi = new ProveedorUi(createProveedorUseCase, updateProveedorUseCase,
                                deleteProveedorUseCase, findByIdProveedorUseCase, findByIdProveedorDtoUseCase,
                                findAllProveedorUseCase, findAllProveedorDtoUseCase);

                // proveedorUi.addProveedor();
                // proveedorUi.updateProveedor();
                // proveedorUi.deleteProveedor();
                // proveedorUi.findAllProveedores();
                // proveedorUi.findAllProveedoresDto();
                // proveedorUi.findByIdProveedor();
                // proveedorUi.findByIdProveedorDto();

                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                ProductService productService = new ProductRepository();

                CreateProductUseCase createProductUseCase = new CreateProductUseCase(productService);
                UpdateProductUseCase updateProductUseCase = new UpdateProductUseCase(productService);
                DeleteProductUseCase deleteProductUseCase = new DeleteProductUseCase(productService);
                FindByIdProductUseCase findByIdProductUseCase = new FindByIdProductUseCase(productService);
                FindByIdProductDtoUseCase findByIdProductDtoUseCase = new FindByIdProductDtoUseCase(productService);
                FindAllProductUseCase findAllProductUseCase = new FindAllProductUseCase(productService);
                FindAllProductUseDtoCase findAllProductUseDtoCase = new FindAllProductUseDtoCase(productService);

                ProductUi productUi = new ProductUi(createProductUseCase, updateProductUseCase, deleteProductUseCase,
                                findByIdProductUseCase, findByIdProductDtoUseCase, findAllProductUseCase,
                                findAllProductUseDtoCase);

                // productUi.addProduct();
                // productUi.updateProduct();
                // productUi.deleteProduct();
                // productUi.findAllProducts();
                // productUi.findAllProductsDto();
                // productUi.findByIdProduct();
                // productUi.findProductDtoById();
        }
}