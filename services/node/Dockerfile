FROM node:11-alpine

WORKDIR /app

# copy file config to install private node modules
COPY .npmrc /root/
COPY app/ /app
# remove non production files
RUN rm -rf .npmrc

RUN npm ci

# remove file to not send your passwords
RUN rm -f /root/.npmrc

EXPOSE 80

CMD ["npm", "start"]