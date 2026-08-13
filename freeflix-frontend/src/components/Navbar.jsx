// src/components/Navbar.jsx
import React from "react";
import { AppBar, Toolbar, Typography, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function Navbar() {
  const navigate = useNavigate();
  const token = localStorage.getItem("jwt");

  return (
    <AppBar position="static" color="primary">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1, cursor: "pointer" }} onClick={() => navigate("/")}>
          FreeFlix
        </Typography>
        {token ? (
          <Button color="inherit" onClick={() => { localStorage.removeItem("jwt"); navigate("/"); }}>
            Logout
          </Button>
        ) : (
          <Button color="inherit" onClick={() => navigate("/login")}>Login</Button>
        )}
      </Toolbar>
    </AppBar>
  );
}