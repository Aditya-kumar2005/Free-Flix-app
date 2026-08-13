// src/pages/MovieDetail.jsx
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { TextField, Button, Rating, Typography } from "@mui/material";
import api from "../services/api";

export default function MovieDetail() {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);
  const [reviews, setReviews] = useState([]);
  const [rating, setRating] = useState(0);
  const [comment, setComment] = useState("");

  useEffect(() => {
    api.get(`/movies/${id}`).then(res => setMovie(res.data));
    api.get(`/reviews/movie/${id}`).then(res => setReviews(res.data));
  }, [id]);

  const submitReview = async () => {
    await api.post(`/reviews/movie/${id}`, { rating, comment });
    const res = await api.get(`/reviews/movie/${id}`);
    setReviews(res.data);
    setRating(0);
    setComment("");
  };

  if (!movie) return <div>Loading...</div>;

  return (
    <div>
      <Typography variant="h4">{movie.title}</Typography>
      <Typography>{movie.description}</Typography>

      <Typography variant="h6" sx={{ mt: 3 }}>Reviews</Typography>
      {reviews.map(r => (
        <div key={r.id}>
          <Rating value={r.rating} readOnly />
          <Typography>{r.comment}</Typography>
        </div>
      ))}

      <Typography variant="h6" sx={{ mt: 3 }}>Add Review</Typography>
      <Rating value={rating} onChange={(e, val) => setRating(val)} />
      <TextField
        fullWidth
        multiline
        rows={3}
        value={comment}
        onChange={(e) => setComment(e.target.value)}
        sx={{ mt: 2 }}
      />
      <Button variant="contained" sx={{ mt: 2 }} onClick={submitReview}>
        Submit
      </Button>
    </div>
  );
}