
db.createCollection( 'Pago', {validator: {$jsonSchema: {bsonType: 'object',title:'Pago',required: [         'fecha',          'total'],properties: {fecha: {bsonType: 'date'},total: {bsonType: 'double'},idPaypal: {bsonType: 'objectId'},idTarjeta: {bsonType: 'objectId'}}         }      }});  