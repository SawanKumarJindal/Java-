 class MyMouseListener extends MouseAdapter  
    {  
        BufferedImage in;  
          
        public void mouseMoved(java.awt.event.MouseEvent mouseEvent)  
        {  
            end = mouseEvent.getPoint();        // Gets the ending point              
            setParameters();            // Calls a private method  
            if(overlayImage != null)  
            {  
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  
                repaint();  
            }  
        }  
              
        public void mousePressed(java.awt.event.MouseEvent mouseEvent)  
        {  
            if(parent.getTransparent() || parent.getFloodFill() || parent.getReplace()) //only do something on mouseReleased()  
            {  
            }  
            else  
            {  
                done = false;  
                start = mouseEvent.getPoint();  
                if(parent.getCrop())  
                {  
                    setCursorLabel();  
                    size.setVisible(true);  
                }  
            }  
        }  
  
        public void mouseDragged(java.awt.event.MouseEvent mouseEvent)  
        {  
            end = mouseEvent.getPoint();        // Gets the ending point              
            setParameters();            // Calls a private method  
            if(parent.getTransparent() || parent.getFloodFill() || parent.getReplace()) //only do something on mouseReleased()  
            {  
            }  
            else if(parent.getCrop())  
            {  
                setCursorLabel();  
                repaint();  
            }  
            else  
            {  
                JRadioButton shape = parent.getSelected();  // Retrieves a referenced to the selected JRadioButton  
                String type = shape.getText();          // Sets the type of shape to draw  
                Color color = parent.getFore();     // Sets the drawing color  
                if(type.equals("Draw Free"))  
                {  
                    current = new Shape(start.x, start.y, end.x, end.y, type, color, stroke);  
                    repaint();  
                    free = createImage();  
                    start = end;  
                }  
                else if(type.equals("Draw Line"))  
                {  
                    current = new Shape(start.x, start.y, end.x, end.y, type, color, stroke);  
                }  
                else  
                {  
                    current = new Shape(x1, y1, w, h, type, color, stroke);  
                }  
                repaint();  
            }  
        }  
          
        public void mouseReleased(java.awt.event.MouseEvent mouseEvent)  
        {  
            end = mouseEvent.getPoint();  
            in = ImageStack.getImage();  
            BufferedImage i = createImage();  
              
            if(parent.getFloodFill())  
            {  
                floodFill();  
            }  
            else if(parent.getReplace())  
            {  
                replace();  
            }  
            else if(parent.getTransparent())  
            {  
                if(end.x < in.getWidth() && end.y < in.getHeight())   //the user clicked on the image  
                {  
                    Color color = new Color(in.getRGB(end.x, end.y));   //get the color  
                    BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(),BufferedImage.TYPE_INT_ARGB);  
                    Graphics2D g2d = out.createGraphics();                    
                    g2d.drawImage(TransparencyUtil.makeColorTransparent(in, color), 0, 0, null);    
                    g2d.dispose();  
                    ImageStack.addImage(out);  
                    parent.setTransparent(false);  
                }  
            }  
            else if(parent.getCrop())  
            {  
                size.setVisible(false);  
                //crop image  
                i = i.getSubimage(x1 + 1, y1 + 1, w - 1, h - 1);  
                //pop up a dialog  
                int choice = JOptionPane.showConfirmDialog(parent,"Width = " + (w - 2) + "\nHeight = " + (h - 2), "Crop", JOptionPane.OK_CANCEL_OPTION);  
                if(choice == JOptionPane.OK_OPTION)  
                {  
                    ImageStack.addImage(i);  
                }  
                parent.setCrop(false);  
            }  
            else  
            {  
                BufferedImage old = ImageStack.getImage();  
                if(parent.getConstrain() && old != null)  
                {  
                    i = i.getSubimage(0, 0, old.getWidth(), old.getHeight());  
                }  
                ImageStack.addImage(i);  
                current = null;  
            }  
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  
            repaint();  
            revalidate();  
            free = null;    //probably very important. should maybe come before repaint()  
            overlayImage = null;  
            done = true;  
        }  
        private void floodFill()  
        {  
            Point p;  
            ArrayDeque<Point> q = new ArrayDeque<Point>();  
            BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), in.getType());  
            Graphics2D g2d = out.createGraphics();  
            g2d.drawImage(in, 0, 0, null);  
            g2d.dispose();  
            if(end.x < out.getWidth() && end.y < out.getHeight()) //the user clicked on the image  
            {     
                setCursor(new Cursor(Cursor.WAIT_CURSOR));  
                Color color = new Color(in.getRGB(end.x, end.y));   //get the color  
                if(!color.equals(parent.getFore()))  
                {  
                    q.add(end);  
                }  
                while(!q.isEmpty())  
                {  
                    p = q.remove();  
                    out.setRGB(p.x, p.y, parent.getFore().getRGB());  
                    for(int x = p.x - 1; x < p.x + 2; x++)  
                    {  
                        for(int y = p.y - 1; y < p.y + 2; y++)  
                        {  
                            if(x == p.x || y == p.y)    //no catty corner  
                            {  
                                if(x > -1 && y > -1 && x < out.getWidth() && y < out.getHeight())   //part image  
                                {  
                                    Point candidate = new Point(x, y);  
                                    Color c = new Color(out.getRGB(candidate.x, candidate.y));  
                                    if(!c.equals(parent.getFore())) //not the target color  
                                    {  
                                        if(!q.contains(candidate))  //no duplicates  
                                        {  
                                            q.add(candidate);  
                                        }   //end if  
                                    }   //end if  
                                }   //end if  
                            }   //end if  
                        }   //end for  
                    }   //end for  
                }   //end while  
            }   //end if  
            ImageStack.addImage(out);  
            parent.setFloodFill(false);  
        }   //end floodFill()  
          
        private void replace()  
        {  
            Point point = null;  
            Color color = null;  
            BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), in.getType());  
            Graphics2D g2d = out.createGraphics();  
            g2d.drawImage(in, 0, 0, null);  
            g2d.dispose();  
            if(end.x < out.getWidth() && end.y < out.getHeight()) //the user clicked on the image  
            {  
                point = new Point(end.x, end.y);    //get the point  
                color = new Color(in.getRGB(end.x, end.y)); //get the color  
                for(int w = 0; w < out.getWidth(); w++)  
                {  
                    for(int h = 0; h < out.getHeight(); h++)  
                    {  
                        point.setLocation(w, h);  
                        Color candidate = new Color(in.getRGB(point.x, point.y));  
                        if(candidate.equals(color))  
                        {  
                            out.setRGB(point.x, point.y, parent.getFore().getRGB());  
                        }  
                    }  
                }  
                ImageStack.addImage(out);  
                parent.setReplace(false);  
            }  
        }   //end replace()  
    }   // end class MyMouseListener  
}   // end class DrawingArea  