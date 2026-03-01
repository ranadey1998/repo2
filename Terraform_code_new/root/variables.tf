variable "subscription_id" {
  description = "Azure subscription ID"
  type        = string
}

variable "resource_group_name" {
  description = "Resource group name"
  type        = string
}

variable "location" {
  description = "Azure region"
  type        = string
}

variable "logic_app_name" {
  description = "Logic App name"
  type        = string
}

variable "postgres_server_name" {
  description = "PostgreSQL server name"
  type        = string
}

variable "environment" {
  description = "Environment (dev/test/prod)"
  type        = string
}
