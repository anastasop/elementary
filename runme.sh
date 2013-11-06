#!/bin/sh

curl 'http://localhost:8080/hello?draft=one'

curl -XPOST -H"Content-Type: application/json" -d'{ "name": "Greece", "capital": "Athens" }' http://localhost:8080/countries
curl -XPOST -H"Content-Type: application/json" -d'{ "name": "Italy", "capital": "Rome" }' http://localhost:8080/countries
curl -XPOST -H"Content-Type: application/json" -d'{ "name": "France", "capital": "Paris" }' http://localhost:8080/countries
curl -XPOST -H"Content-Type: application/json" -d'{ "name": "England", "capital": "London" }' http://localhost:8080/countries
curl http://localhost:8080/countries
