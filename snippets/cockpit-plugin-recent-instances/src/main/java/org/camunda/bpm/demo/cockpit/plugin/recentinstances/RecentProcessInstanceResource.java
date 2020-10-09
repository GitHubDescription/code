package org.camunda.bpm.demo.cockpit.plugin.recentinstances;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginResource;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public class RecentProcessInstanceResource extends AbstractCockpitPluginResource {

  public RecentProcessInstanceResource(String engineName) {
    super(engineName);
  }

  @GET
  @Path("process-instance")
  public List<ExtendedProcessInstanceDto> getRecentProcessInstances() {
    ArrayList<ExtendedProcessInstanceDto> recentProcessInstances = new ArrayList<ExtendedProcessInstanceDto>();
    
    // processes being started by us:    
    List<HistoricProcessInstance> processInstances = getProcessEngine().getHistoryService() //
        .createHistoricProcessInstanceQuery() //
        .orderByProcessInstanceStartTime().desc() //
        .listPage(0, 20);
    for (HistoricProcessInstance pi : processInstances) {
      ExtendedProcessInstanceDto dto = ExtendedProcessInstanceDto.fromProcessInstance(pi);
      
      try {
        ProcessDefinition pd = getProcessEngine().getRepositoryService().getProcessDefinition(dto.getProcessDefinitionId());
        dto.setProcessDefinition(pd);
      }
      catch (Exception ex) {
        dto.setProcessDefinitionId(pi.getProcessDefinitionId());
      }
      dto.setStartTime(pi.getStartTime());
      
      recentProcessInstances.add( dto );
    }   
    
    return recentProcessInstances;
  }

}
