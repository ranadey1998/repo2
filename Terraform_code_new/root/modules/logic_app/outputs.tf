output "logic_app_id" {
  description = "Logic App resource ID"
  value       = azurerm_logic_app_workflow.this.id
}

output "logic_app_identity_principal_id" {
  description = "System-assigned identity principal ID"
  value       = azurerm_logic_app_workflow.this.identity[0].principal_id
}
