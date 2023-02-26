#!/bin/bash

# Send $1 petitions to $PUBLIC_API_URL

PUBLIC_API_URL="http://localhost:8080/subscription/subscribe"

if [[ $# -ne 1 ]]; then
	numPetitions=5 # Default value
else
	numPetitions=$1
fi

for i in $(seq $numPetitions)
do 
	curl -X POST $PUBLIC_API_URL \
		-H 'Content-Type: application/json' \
		--data-raw '{"email": "pedro_'$i'@mail.com"}'
done
