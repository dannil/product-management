FROM node:22 AS builder
WORKDIR /opt/app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:1.17.4 AS runner
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /opt/app/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
