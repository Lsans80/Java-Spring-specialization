
db.createCollection( 'Producto', {validator: {$jsonSchema: {bsonType: 'object',title:'Producto',required: [         'idCategoria',          'CantidadProducto'],properties: {nombre: {bsonType: 'string'},idCategoria: {bsonType: 'objectId'},descripcion: {bsonType: 'string'},imagen: {bsonType: 'binData'},precio: {bsonType: 'double'},CantidadProducto: {bsonType: 'objectId'}}         }      }});  