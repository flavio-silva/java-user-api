import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api/person/v1'
});

export default api;