package com.farmacia.via_administracion.domain.service;

import java.util.List;

import com.farmacia.via_administracion.domain.entity.ViaAdminis;

public interface ViaAdminisService {

    public void addViaAdminis(ViaAdminis viaAdminis);

    public void updateViaAdminis(ViaAdminis viaAdminis);

    public void deleteViaAdminis(int id);

    ViaAdminis findViaAdminisById(int id);

    List<ViaAdminis> findAllViasAdminis();

}
