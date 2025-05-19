# Użyj obrazu Node.js jako bazowego
FROM node:18

# Ustaw katalog roboczy
WORKDIR /app

# Skopiuj pliki package.json i package-lock.json
COPY package*.json ./

# Zainstaluj zależności
RUN npm install --legacy-peer-deps

# Skopiuj pozostałe pliki projektu
COPY . .

# Otwórz port 3000 (lub inny, jeśli aplikacja działa na innym porcie)
EXPOSE 3000

# Uruchom aplikację w trybie deweloperskim
CMD ["npm", "run", "dev"]