
db.createCollection( 'Tienda', {validator: {$jsonSchema: {bsonType: 'object',title:'Tienda',required: [         'idLocalidad'],properties: {direccion: {bsonType: 'string'},codigoPostal: {bsonType: 'int'},idLocalidad: {bsonType: 'objectId'}}         }      }});  