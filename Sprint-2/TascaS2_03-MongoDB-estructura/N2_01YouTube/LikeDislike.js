
db.createCollection( 'LikeDislike', {validator: {$jsonSchema: {bsonType: 'object',title:'LikeDislike',required: [         'likeDislike',          'fecheHora',          'idUsuario'],properties: {likeDislike: {enum: like, dislike},fecheHora: {bsonType: 'timestamp'},idUsuario: {bsonType: 'objectId'},idVideo: {bsonType: 'objectId'},idComentario: {bsonType: 'objectId'}}         }      }});  