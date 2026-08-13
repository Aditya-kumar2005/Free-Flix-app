This README explains how to import the provided `data/movies.json` into MongoDB (Compass or mongoimport).

Prerequisites
- MongoDB server running and accessible (default: mongodb://localhost:27017)
- `mongoimport` available in PATH OR MongoDB Compass

Files
- `data/movies.json` - JSON array with movie documents ready for import.

Import with mongoimport (JSON array)

PowerShell / Command Prompt:

```powershell
# Import into database 'freeflix' collection 'movies'
mongoimport --uri "mongodb://localhost:27017/freeflix" --collection movies --file data/movies.json --jsonArray --drop
```

Notes:
- `--jsonArray` tells `mongoimport` the file is a single JSON array of documents.
- `--drop` will drop the collection before importing; remove it to append instead.

Import with MongoDB Compass (GUI)
1. Open MongoDB Compass and connect to `mongodb://localhost:27017`.
2. If `freeflix` database does not exist, click "Create Database" and create `freeflix` with collection `movies` (or let import create it).
3. Open the `movies` collection and click "Import Data".
4. Choose "JSON" and pick `data/movies.json`.
5. Check "File contains JSON array" if prompted and click Import.

Seeding other collections
- The repository contains `seed_freeflix.js` which inserts multiple collections (users, licenses, movies, reviews, watch_history, ad_slots).
- If you prefer to import other collections as JSON files, convert corresponding parts of `seed_freeflix.js` into JSON arrays (e.g., `data/users.json`, `data/licenses.json`, etc.) and run `mongoimport` for each collection.

Troubleshooting
- If `mongoimport` command is not found, install MongoDB Database Tools or use MongoDB Compass.
- If authentication is enabled on the server, include credentials in the `--uri` (e.g., `mongodb://user:pass@host:27017/freeflix`) or use `--username`/`--password` flags.

Example: import multiple collections
```powershell
mongoimport --uri "mongodb://localhost:27017/freeflix" --collection users --file data/users.json --jsonArray --drop
mongoimport --uri "mongodb://localhost:27017/freeflix" --collection movies --file data/movies.json --jsonArray --drop
mongoimport --uri "mongodb://localhost:27017/freeflix" --collection reviews --file data/reviews.json --jsonArray --drop
```
