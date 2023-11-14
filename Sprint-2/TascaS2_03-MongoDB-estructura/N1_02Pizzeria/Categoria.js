
db.createCollection( 'Categoria', {validator: {$jsonSchema: {bsonType: 'object',title:'Categoria',properties: {categoria: {bsonType: 'string'}}         }      }});  