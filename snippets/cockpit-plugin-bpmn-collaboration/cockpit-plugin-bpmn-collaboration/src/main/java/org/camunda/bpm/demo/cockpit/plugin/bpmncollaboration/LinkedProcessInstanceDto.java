package org.camunda.bpm.demo.cockpit.plugin.bpmncollaboration;

import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.rest.dto.LinkableDto;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public class LinkedProcessInstanceDto extends LinkableDto {
  
  /**
   * copied from {@link ProcessInstanceDto} (wrong visibility makes reusing them impossible)
   */
  private String id;  
  private String processDefinitionId;
  private String businessKey;
  private boolean ended;
  private boolean suspended;

  /**
   * own stuff
   */
  private String processDefinitionKey;
  private String processDefinitionName;
  
  public static LinkedProcessInstanceDto fromProcessInstance(ProcessInstance instance) {    
    LinkedProcessInstanceDto result = new LinkedProcessInstanceDto();
    result.id = instance.getId();
    result.processDefinitionId = instance.getProcessDefinitionId();
    result.businessKey = instance.getBusinessKey();
    result.ended = instance.isEnded();
    result.suspended = instance.isSuspended();
    return result;
  }
  
  public void setProcessDefinition(ProcessDefinition processDefinition) {
    this.processDefinitionId = processDefinition.getId();
    this.processDefinitionKey = processDefinition.getKey();
    this.processDefinitionName = processDefinition.getName();
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProcessDefinitionId() {
    return processDefinitionId;
  }

  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }

  public String getBusinessKey() {
    return businessKey;
  }

  public void setBusinessKey(String businessKey) {
    this.businessKey = businessKey;
  }

  public boolean isEnded() {
    return ended;
  }

  public void setEnded(boolean ended) {
    this.ended = ended;
  }

  public boolean isSuspended() {
    return suspended;
  }

  public void setSuspended(boolean suspended) {
    this.suspended = suspended;
  }

  public String getProcessDefinitionKey() {
    return processDefinitionKey;
  }

  public void setProcessDefinitionKey(String processDefinitionKey) {
    this.processDefinitionKey = processDefinitionKey;
  }

  public String getProcessDefinitionName() {
    return processDefinitionName;
  }

  public void setProcessDefinitionName(String processDefinitionName) {
    this.processDefinitionName = processDefinitionName;
  }


  
}