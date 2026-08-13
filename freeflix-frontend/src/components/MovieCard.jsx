import React from "react";

export default function MovieCard({ movie, onPlay }) {
  return (
    <div className="card">
      <img src={movie.posterUrl} alt={movie.title} />
      <h3>{movie.title}</h3>
      <button onClick={() => onPlay(movie.id)}>▶ Play</button>
    </div>
  );
}