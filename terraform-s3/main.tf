# Define the cloud provider
provider "aws" {
	region = var.aws_region
}


# Create an S3 bucket
resource "aws_s3_bucket" "example_bucket" {
	bucket = var.bucket_name
	tags = {
		Name = "App Bucket"
		Environment = "Dev"
		}
}