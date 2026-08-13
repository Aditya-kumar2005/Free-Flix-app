// src/components/Player.jsx
import React, { useEffect, useRef, useState } from "react";
import Hls from "hls.js";

export default function Player({ session }) {
  const videoRef = useRef();
  const [queue, setQueue] = useState([]);

  useEffect(() => {
    // Build playback queue: preroll -> movie -> midrolls -> postroll
    const q = [];
    if (session.preroll) q.push(session.preroll);
    q.push(session.moviePlaylist);
    if (session.midrolls) q.push(...session.midrolls);
    if (session.postroll) q.push(session.postroll);
    setQueue(q);
  }, [session]);

  useEffect(() => {
    if (queue.length > 0) {
      play(queue[0]);
    }
  }, [queue]);

  const play = (url) => {
    if (Hls.isSupported()) {
      const hls = new Hls();
      hls.loadSource(url);
      hls.attachMedia(videoRef.current);
      videoRef.current.onended = () => {
        const next = queue.shift();
        if (next) play(next);
      };
    } else {
      videoRef.current.src = url;
    }
  };

  return <video ref={videoRef} controls style={{ width: "100%" }} />;
}