
db.createCollection( 'Album', {validator: {$jsonSchema: {bsonType: 'object',title:'Album',required: [         'titulo',          'anyoPublicacion',          'imagenPortada',          'Artista'],properties: {titulo: {bsonType: 'string'},anyoPublicacion: {bsonType: 'int'},imagenPortada: {bsonType: 'binData'},Artista: {bsonType: 'objectId'}}         }      }});  