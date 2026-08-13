import React, { useEffect, useState } from "react";
import axios from "axios";
import MovieCard from "../components/MovieCard";
import Player from "../components/Player";

export default function Home() {
  const [movies, setMovies] = useState([]);
  const [session, setSession] = useState(null);

  useEffect(() => {
    axios.get("/movies/latest").then(res => setMovies(res.data));
  }, []);

  const playMovie = async (id) => {
    const res = await axios.get(`/stream/${id}/session`);
    setSession(res.data);
  };

  return (
    <div>
      <h1>🎬 FreeFlix</h1>
      <div className="grid">
        {movies.map(m => (
          <MovieCard key={m.id} movie={m} onPlay={playMovie} />
        ))}
      </div>
      {session && <Player playlistUrl={session.moviePlaylist} />}
    </div>
  );
}