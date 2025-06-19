output "s3_bucket_name" {
  value = aws_s3_bucket.my_bucket.id
}

output "ec2_public_ip" {
  value = aws_instance.my_ec2.public_ip
}

output "rds_endpoint" {
  value = aws_db_instance.my_db.endpoint
}

output "lambda_name" {
  value = aws_lambda_function.my_lambda.function_name
}

output "dynamodb_table" {
  value = aws_dynamodb_table.my_table.name
}
