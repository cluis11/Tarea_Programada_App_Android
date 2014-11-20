[08:32:43 p.m.] Luis Castro: class Preguntas
 def initialize()
  File.open('preguntas.txt', 'a')
 end

 def preguntas_()
  @temp=""
  File.open('preguntas.txt','r') do |f|
   while line = f.gets
    @temp=@temp+line
   end
  end
  @temp
 end

 def nueva_pregunta(preg) 
  @id=self.genera_id()
  File.open('preguntas.txt', 'a') do |f|
     f.puts @id+"+"+preg
  end
  preg
 end

 def genera_id()
  @temp=self.preguntas_()
  @temp=@temp.split(" ")
  @temp=@temp.last
  @temp=@temp.split("+")
  @temp=@temp.first.to_i+1
  @temp.to_s
 end
end
