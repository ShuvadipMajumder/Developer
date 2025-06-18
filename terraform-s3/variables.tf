variable "aws_region" {
  description = "The AWS region where resources will be created"
  type        = string
  default     = "us-east-2"
}

variable "bucket_name" {
  description = "Unique name for the S3 bucket"
  type        = string
}