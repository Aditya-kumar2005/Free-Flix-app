# scripts/transcode_to_hls.sh
# Usage: ./transcode_to_hls.sh input.mp4 output_dir/movie123
set -e
INPUT="$1"
OUTDIR="$2"
mkdir -p "$OUTDIR"
ffmpeg -i "$INPUT" \
  -codec: copy -start_number 0 \
  -hls_time 6 -hls_list_size 0 -f hls "$OUTDIR/master.m3u8"