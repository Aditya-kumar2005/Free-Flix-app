# scripts/ingest_public_domain.sh
# Example ingestion for public domain/indie content
set -e
MOVIE_ID="$1"
TITLE="$2"
DESC="$3"
POSTER_URL="$4"
GENRES="$5" # comma-separated
HLS_DIR="src/main/resources/static/hls/$MOVIE_ID"
./scripts/transcode_to_hls.sh "./assets/$MOVIE_ID.mp4" "$HLS_DIR"

# Create a JSON payload for MovieController /admin
cat <<JSON
{
  "title": "$TITLE",
  "description": "$DESC",
  "posterUrl": "$POSTER_URL",
  "genres": [$(echo "$GENRES" | sed 's/,/","/g' | sed 's/^/"/' | sed 's/$/"/')],
  "hlsPlaylistUrl": "/hls/$MOVIE_ID/master.m3u8",
  "publicDomain": true,
  "averageRating": 0.0,
  "views": 0
}
JSON