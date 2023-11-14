
db.createCollection( 'Provincia', {validator: {$jsonSchema: {bsonType: 'object',title:'Provincia',properties: {nombre: {bsonType: 'string'}}         }      }});  