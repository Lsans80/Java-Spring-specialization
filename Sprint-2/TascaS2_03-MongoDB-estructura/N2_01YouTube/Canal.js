
db.createCollection( 'Canal', {validator: {$jsonSchema: {bsonType: 'object',title:'Canal',required: [         'nombre',          'fechaCeracion',          'Usuario'],properties: {nombre: {bsonType: 'string'},descripcion: {bsonType: 'string'},fechaCeracion: {bsonType: 'timestamp'},Usuario: {bsonType: 'objectId'}}         }      }});  