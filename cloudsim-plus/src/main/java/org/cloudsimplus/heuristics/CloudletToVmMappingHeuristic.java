/*
 * CloudSim Plus: A modern, highly-extensible and easier-to-use Framework for
 * Modeling and Simulation of Cloud Computing Infrastructures and Services.
 * http://cloudsimplus.org
 *
 *     Copyright (C) 2015-2016  Universidade da Beira Interior (UBI, Portugal) and
 *     the Instituto Federal de Educação Ciência e Tecnologia do Tocantins (IFTO, Brazil).
 *
 *     This file is part of CloudSim Plus.
 *
 *     CloudSim Plus is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CloudSim Plus is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CloudSim Plus. If not, see <http://www.gnu.org/licenses/>.
 */
package org.cloudsimplus.heuristics;

import java.util.Collections;
import java.util.List;

import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.vms.Vm;

/**
 * Provides the methods to be used for implementing a heuristic to get
 * a sub-optimal solution for mapping Cloudlets to Vm's.
 *
 * @author Manoel Campos da Silva Filho
 * @since CloudSim Plus 1.0
 */
public interface CloudletToVmMappingHeuristic extends Heuristic<CloudletToVmMappingSolution> {

    /**
     *
     * @return the list of cloudlets to be mapped to {@link #getVmList() available Vm's}.
     */
    List<Cloudlet> getCloudletList();

    /**
     *
     * @return the list of available Vm's to host Cloudlets.
     */
    List<Vm> getVmList();

    /**
     * Sets the list of Cloudlets to be mapped to {@link #getVmList() available Vm's}.
     * @param cloudletList the list of Cloudlets to set
     */
    void setCloudletList(List<Cloudlet> cloudletList);

    /**
     * Sets the list of available VMs to host Cloudlets.
     * @param vmList the list of VMs to set
     */
    void setVmList(List<Vm> vmList);

    /**
     * A property that implements the Null Object Design Pattern for {@link Heuristic}
     * objects.
     */
    CloudletToVmMappingHeuristic NULL = new CloudletToVmMappingHeuristicNull();
}

/**
 * A class to allow the implementation of Null Object Design Pattern
 * for this interface and extensions of it.
 */
class CloudletToVmMappingHeuristicNull extends HeuristicNull<CloudletToVmMappingSolution> implements CloudletToVmMappingHeuristic {
    @Override public List<Cloudlet> getCloudletList() { return Collections.EMPTY_LIST; }
    @Override public List<Vm> getVmList() { return Collections.EMPTY_LIST; }
    @Override public void setCloudletList(List<Cloudlet> cloudletList) {}
    @Override public void setVmList(List<Vm> vmList) {}
}
