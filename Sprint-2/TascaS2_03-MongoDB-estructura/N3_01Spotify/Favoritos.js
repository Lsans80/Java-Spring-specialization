
db.createCollection( 'Favoritos', {validator: {$jsonSchema: {bsonType: 'object',title:'Favoritos',required: [         'idUsuario'],properties: {idCancion: {bsonType: 'objectId'},idAlbum: {bsonType: 'objectId'},idUsuario: {bsonType: 'objectId'}}         }      }});  