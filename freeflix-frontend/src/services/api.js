// src/services/api.js
import axios from "axios";

const api = axios.create({
  baseURL: "/", // proxied to 8080
});

api.interceptors.request.use((config) => {
  const token = localStorage.getItem("jwt");
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

export default api;