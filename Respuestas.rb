class Respuestas
 def initialize()
  File.open('usuarios.txt', 'a')
 end

 def respuestas_()
  @temp=""
  File.open('respuestas.txt','r') do |f|
   while line = f.gets
    @temp=@temp+line
   end
  end
  @temp
 end

 def nueva_respuesta(res) 
  File.open('respuestas.txt', 'a') do |f|
     f.puts res
  end
  res
 end
end
