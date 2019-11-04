import axios from 'axios';

const api = axios.create({
  baseURL: 'http://fiap-microservices:8080/api/person/v1'
});

export default api;