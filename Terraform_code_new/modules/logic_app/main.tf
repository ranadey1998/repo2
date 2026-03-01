resource "azurerm_logic_app_workflow" "this" {
  name                = var.logic_app_name
  location            = var.location
  resource_group_name = var.resource_group_name
  enabled             = true

  identity {
    type = "SystemAssigned"
  }

  tags = {
    environment = var.environment
  }
}

