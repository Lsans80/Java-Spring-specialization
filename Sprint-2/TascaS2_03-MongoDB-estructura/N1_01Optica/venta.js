
db.createCollection( 'venta', {validator: {$jsonSchema: {bsonType: 'object',title:'venta',required: [         'idGafa',          'idCliente'],properties: {fechaVenta: {bsonType: 'date'},empleado: {bsonType: 'string'},idGafa: {bsonType: 'objectId'},idCliente: {bsonType: 'objectId'}}         }      }});  