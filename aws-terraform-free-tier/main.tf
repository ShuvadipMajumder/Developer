provider "aws" {
  region = var.aws_region
}

# 1. S3 Bucket
resource "aws_s3_bucket" "my_bucket" {
  bucket = var.s3_bucket_name
}

# 2. EC2 Instance
resource "aws_instance" "my_ec2" {
  ami           = var.ec2_ami_id
  instance_type = "t2.micro"
  key_name      = var.ec2_key_name

  tags = {
    Name = "MyFreeTierEC2"
  }
}

# 3. RDS Instance
resource "aws_db_instance" "my_db" {
  allocated_storage    = 20
  engine               = "mysql"
  engine_version       = "8.0"
  instance_class       = "db.t3.micro"
  db_name              = "mydb"
  username             = var.db_username
  password             = var.db_password
  skip_final_snapshot  = true
  publicly_accessible  = true
}

# 4. Lambda Function
resource "aws_iam_role" "lambda_exec_role" {
  name = "lambda_exec_role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [{
      Action = "sts:AssumeRole",
      Effect = "Allow",
      Principal = {
        Service = "lambda.amazonaws.com"
      }
    }]
  })
}

resource "aws_lambda_function" "my_lambda" {
  filename         = "lambda.zip"
  function_name    = "MyFreeTierLambda"
  role             = aws_iam_role.lambda_exec_role.arn
  handler          = "index.handler"
  runtime          = "nodejs18.x"
  source_code_hash = filebase64sha256("lambda.zip")
}

# 5. DynamoDB Table
resource "aws_dynamodb_table" "my_table" {
  name           = "MyFreeTierTable"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "id"

  attribute {
    name = "id"
    type = "S"
  }
}
