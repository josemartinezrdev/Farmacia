package com.farmacia.via_administracion.application;

import com.farmacia.via_administracion.domain.entity.ViaAdminis;
import com.farmacia.via_administracion.domain.service.ViaAdminisService;

public class FindByIdViaAdminisUseCase {

    private ViaAdminisService viaAdminisService;

    public FindByIdViaAdminisUseCase(ViaAdminisService viaAdminisService) {
        this.viaAdminisService = viaAdminisService;
    }

    public ViaAdminis execute(int id) {
        return viaAdminisService.findViaAdminisById(id);
    }

}
