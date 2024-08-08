package com.farmacia.via_administracion.application;

import java.util.List;

import com.farmacia.via_administracion.domain.entity.ViaAdminis;
import com.farmacia.via_administracion.domain.service.ViaAdminisService;

public class FindViaAdminisUseCase {
    private ViaAdminisService viaAdminisService;

    public FindViaAdminisUseCase(ViaAdminisService viaAdminisService) {
        this.viaAdminisService = viaAdminisService;
    }

    public List<ViaAdminis> execute() {
        return viaAdminisService.findAllViasAdminis();
    }

}
