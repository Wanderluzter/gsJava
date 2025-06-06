#!/bin/bash

# ⚙ CONFIG
RG="api-rg"
LOCATION="brazilsouth"
ACI_NAME="gsjava-container"
IMAGE="wanderluzter/gsjava-api:latest"
DNS_LABEL="gsjavaapi$RANDOM"

echo "📦 Criando Resource Group (se necessário)..."
az group create --name $RG --location $LOCATION

echo "🚀 Criando instância ACI com imagem do Docker Hub..."
az container create \
  --resource-group $RG \
  --name $ACI_NAME \
  --image $IMAGE \
  --cpu 1 \
  --memory 1 \
  --ports 8080 \
  --dns-name-label $DNS_LABEL \
  --query ipAddress.fqdn \
  --output tsv \
  --os-type Linux

echo "✅ API disponível em:"
echo "http://$DNS_LABEL.$LOCATION.azurecontainer.io:8080"