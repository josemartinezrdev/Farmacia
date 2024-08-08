package com.farmacia.via_administracion.application;

import com.farmacia.via_administracion.domain.service.ViaAdminisService;

public class DeleteViaAdminisUseCase {
    private ViaAdminisService viaAdminisService;

    public DeleteViaAdminisUseCase(ViaAdminisService viaAdminisService) {
        this.viaAdminisService = viaAdminisService;
    }

    public void execute(int id) {
        viaAdminisService.deleteViaAdminis(id);
    }

}
