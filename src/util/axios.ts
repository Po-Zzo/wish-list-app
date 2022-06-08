import axios from 'axios';
import * as https from 'https';

const httpsAgent = new https.Agent({
  rejectUnauthorized: false,
})
axios.defaults.httpsAgent = httpsAgent

axios.interceptors.request.use(function (config) {
  return config;
}, function(error) {
  return Promise.reject(error);
});

axios.interceptors.response.use(function (response) {
  return response;
}, function (error) {
  return Promise.reject(error);
})
