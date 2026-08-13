// Clear old data
db.users.deleteMany({});
db.movies.deleteMany({});
db.reviews.deleteMany({});
db.watch_history.deleteMany({});
db.ad_slots.deleteMany({});
db.licenses.deleteMany({});

// Users
db.users.insertMany([
  {
    _id: "user1",
    email: "aditya@example.com",
    passwordHash: "$2a$10$hashedpassword", // bcrypt hash
    roles: ["USER"],
    createdAt: new Date()
  },
  {
    _id: "admin1",
    email: "admin@freeflix.com",
    passwordHash: "$2a$10$hashedadminpassword",
    roles: ["ADMIN"],
    createdAt: new Date()
  }
]);

// Licenses
db.licenses.insertMany([
  {
    _id: "license1",
    source: "PUBLIC_DOMAIN",
    rightsHolder: "George Romero Estate",
    termsUrl: "http://example.com/license/notld",
    valid: true
  },
  {
    _id: "license2",
    source: "INDIE_PARTNER",
    rightsHolder: "Indie Studio XYZ",
    termsUrl: "http://example.com/license/indie",
    valid: true
  }
]);

// Movies
db.movies.insertMany([
  {
    _id: "movie1",
    title: "Night of the Living Dead",
    description: "Public domain classic horror.",
    posterUrl: "/images/notld.jpg",
    genres: ["Horror", "Classic"],
    hlsPlaylistUrl: "/hls/notld/master.m3u8",
    releaseDate: ISODate("1968-10-01T00:00:00Z"),
    publicDomain: true,
    licenseId: "license1",
    averageRating: 4.2,
    views: 10234
  },
  {
    _id: "movie2",
    title: "Indie Sci-Fi Adventure",
    description: "An indie film exploring futuristic worlds.",
    posterUrl: "/images/indie.jpg",
    genres: ["Sci-Fi", "Adventure"],
    hlsPlaylistUrl: "/hls/indie/master.m3u8",
    releaseDate: ISODate("2024-05-01T00:00:00Z"),
    publicDomain: false,
    licenseId: "license2",
    averageRating: 3.8,
    views: 500
  }
]);

// Reviews
db.reviews.insertMany([
  {
    _id: "review1",
    movieId: "movie1",
    userId: "user1",
    rating: 5,
    comment: "A timeless horror masterpiece!",
    createdAt: new Date()
  },
  {
    _id: "review2",
    movieId: "movie2",
    userId: "user1",
    rating: 4,
    comment: "Loved the creativity of this indie film.",
    createdAt: new Date()
  }
]);

// Watch history
db.watch_history.insertMany([
  {
    _id: "history1",
    userId: "user1",
    movieId: "movie1",
    startedAt: new Date(),
    finishedAt: new Date(),
    secondsWatched: 5400
  }
]);

// Ad slots
db.ad_slots.insertMany([
  {
    _id: "ad1",
    name: "preroll",
    adVideoHlsUrl: "/hls/ads/preroll/master.m3u8",
    durationSeconds: 15,
    active: true
  },
  {
    _id: "ad2",
    name: "midroll",
    adVideoHlsUrl: "/hls/ads/midroll/master.m3u8",
    durationSeconds: 30,
    active: true
  },
  {
    _id: "ad3",
    name: "postroll",
    adVideoHlsUrl: "/hls/ads/postroll/master.m3u8",
    durationSeconds: 20,
    active: true
  }
]);

print("✅ FreeFlix seed data inserted successfully!");