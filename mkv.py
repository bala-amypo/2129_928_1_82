import os
import re

# IMPORTANT: use current folder
FOLDER = "videos"

JUNK_PATTERNS = [
    r'www\s*\S*',
    r'1tamilmv',
    r'pink',
    r'one',

    # Language / subs
    r'\b(tamil|telugu|hindi|malayalam|true|esub)\b',

    # Years
    r'\b(19\d{2}|20\d{2})\b',

    # Quality / resolution
    r'\b(480p|720p|1080p|2160p|4k|hdr|sdr|hd|fullhd)\b',

    # Source
    r'\b(web[- ]?dl|webrip|hdrip|bluray|hdtv)\b',

    # Video codecs
    r'\b(x264|x265|h\.?264|h\.?265|hevc|avc)\b',

    # Audio codecs
    r'\b(aac|ac3|ddp?|atmos|dts|truehd)\b',

    # Channels
    r'\b(5\.1|7\.1|2\.0)\b',

    # Sizes
    r'\b\d+(\.\d+)?\s*(gb|mb)\b',

    # Extra junk
    r'\b(extended|unrated|proper|repack)\b',
]

def clean_name(filename):
    name = os.path.splitext(filename)[0]

    # Convert dots & underscores to spaces
    name = name.replace(".", " ").replace("_", " ")

    # Detect season info (S01, S02 etc.)
    season_match = re.search(r'\bS\d{2}\b', name, re.IGNORECASE)
    season = season_match.group(0).upper() if season_match else ""

    # Remove brackets
    name = re.sub(r'\(.*?\)', '', name)
    name = re.sub(r'\[.*?\]', '', name)

    # Remove junk patterns
    for pattern in JUNK_PATTERNS:
        name = re.sub(pattern, '', name, flags=re.IGNORECASE)

    # Remove season temporarily (to avoid deletion)
    name = re.sub(r'\bS\d{2}\b', '', name, flags=re.IGNORECASE)

    # Remove invalid characters
    name = re.sub(r'[<>:"/\\|?*-]', ' ', name)

    # Normalize spaces
    name = re.sub(r'\s+', ' ', name).strip()

    # Reattach season if exists
    if season:
        name = f"{name} {season}"

    return name

def main():
    renamed = 0

    for file in os.listdir(FOLDER):
        if not file.lower().endswith(".mkv"):
            continue

        old_path = os.path.join(FOLDER, file)
        new_title = clean_name(file)
        new_name = f"{new_title}.mkv"
        new_path = os.path.join(FOLDER, new_name)

        if old_path == new_path:
            continue

        if os.path.exists(new_path):
            print(f"⚠️ Skipped (exists): {new_name}")
            continue

        os.rename(old_path, new_path)
        print(f"✅ Renamed → {new_name}")
        renamed += 1

    if renamed == 0:
        print("✔ All MKV files are already clean. No changes needed.")

if __name__ == "__main__":
    main()
