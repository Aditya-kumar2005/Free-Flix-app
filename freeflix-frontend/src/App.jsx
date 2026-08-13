// src/App.jsx
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { CssBaseline, Container } from "@mui/material";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Login from "./pages/Login";
import MovieDetail from "./pages/MovieDetail";

export default function App() {
  return (
    <BrowserRouter>
      <CssBaseline />
      <Navbar />
      <Container maxWidth="lg" sx={{ mt: 3 }}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/movie/:id" element={<MovieDetail />} />
        </Routes>
      </Container>
    </BrowserRouter>
  );
}