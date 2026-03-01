module "logic_app" {
  source = "./modules/logic_app"

  logic_app_name      = var.logic_app_name
  location            = var.location
  resource_group_name = var.resource_group_name
  environment         = var.environment
}
